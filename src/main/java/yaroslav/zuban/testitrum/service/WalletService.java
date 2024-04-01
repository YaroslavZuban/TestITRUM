package yaroslav.zuban.testitrum.service;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import yaroslav.zuban.testitrum.enum_package.OperationType;
import yaroslav.zuban.testitrum.entity.Wallet;

import java.util.Optional;

public interface WalletService {
    Optional<Wallet> findWalled(int walledId);

    Wallet createOperation(int id, OperationType operationType, double amount);
}