package yaroslav.zuban.testitrum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import yaroslav.zuban.testitrum.enum_package.OperationType;
import yaroslav.zuban.testitrum.entity.Wallet;
import yaroslav.zuban.testitrum.exception.NotEnoughMoneyException;
import yaroslav.zuban.testitrum.repository.WalletRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultWalletService implements WalletService {
    private final WalletRepository walletRepository;

    @Override
    public Optional<Wallet> findWalled(int walledId) {
        return this.walletRepository.findById(walledId);
    }

    @Override
    @Transactional
    public Wallet createOperation(int id, OperationType operationType, double amount) {
        Wallet wallet = this.walletRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Wallet with id " + id + " not found"));

        if (operationType.equals(OperationType.WITHDRAW) && wallet.getAmount() < amount) {
            throw new NotEnoughMoneyException("Insufficient funds to withdraw: " + amount);
        }

        if (operationType.equals(OperationType.DEPOSIT)) {
            wallet.setAmount(wallet.getAmount() + amount);
        } else {
            wallet.setAmount(wallet.getAmount() - amount);
        }

        walletRepository.save(wallet);

        return wallet;
    }
}