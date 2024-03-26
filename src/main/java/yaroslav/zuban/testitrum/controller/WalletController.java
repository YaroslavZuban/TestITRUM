package yaroslav.zuban.testitrum.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import yaroslav.zuban.testitrum.controller.payload.WalletPayload;
import yaroslav.zuban.testitrum.entity.Wallet;
import yaroslav.zuban.testitrum.service.NotEnoughMoneyException;
import yaroslav.zuban.testitrum.service.WalletService;

import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class WalletController {
    private final WalletService walletService;


    @GetMapping("wallets/{walletId:\\d}")
    public Wallet findWallet(@PathVariable("walletId") int walletId) {
        return this.walletService.findWalled(walletId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "walled.errors.id.not_found"));
    }

    @PostMapping(value = "wallet", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createOperation(@Valid @RequestBody(required = false) WalletPayload payload,
                                             BindingResult bindingResult,
                                             UriComponentsBuilder uriComponentsBuilder) throws BindException {

        if (payload == null || payload.valletId() == null || payload.operationType() == null || payload.amount() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wallet.errors.invalid.json");
        }

        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            try {
                Wallet wallet = this.walletService.
                        createOperation(payload.valletId(), payload.operationType(), payload.amount());

                return ResponseEntity
                        .created(uriComponentsBuilder
                                .replacePath("/api/v1/wallets/{walletId}")
                                .build(Map.of("walletId", wallet.getId())))
                        .body(wallet);
            } catch (NoSuchElementException e) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "wallet.errors.no_such_index");
            } catch (NotEnoughMoneyException e) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "wallet.errors.insufficient.funds");
            }
        }
    }
}