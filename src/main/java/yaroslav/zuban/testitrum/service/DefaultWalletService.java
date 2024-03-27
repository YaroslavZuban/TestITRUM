package yaroslav.zuban.testitrum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
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
    private final PlatformTransactionManager transactionManager;
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

        TransactionDefinition transaction = TransactionDefinition.withDefaults();
        TransactionStatus transactionStatus = transactionManager.getTransaction(transaction);

        if (operationType.equals(OperationType.DEPOSIT)) {
            wallet.setAmount(wallet.getAmount() + amount);
        } else {
            wallet.setAmount(wallet.getAmount() - amount);
        }

        walletRepository.save(wallet);

        System.out.println(wallet.getAmount());

        if(transactionStatus.isRollbackOnly()){
            transactionManager.rollback(transactionStatus);
        }else{
            transactionManager.commit(transactionStatus);
        }

        return wallet;
    }
}