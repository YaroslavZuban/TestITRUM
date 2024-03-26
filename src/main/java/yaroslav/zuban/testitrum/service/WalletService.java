package yaroslav.zuban.testitrum.service;

import yaroslav.zuban.testitrum.entity.OperationType;
import yaroslav.zuban.testitrum.entity.Wallet;

import java.util.Optional;

public interface WalletService {
    Optional<Wallet> findWalled(int walledId);

    Wallet createOperation(int id, OperationType operationType, double amount);
}