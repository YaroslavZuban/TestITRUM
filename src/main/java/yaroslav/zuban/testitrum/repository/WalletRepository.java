package yaroslav.zuban.testitrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yaroslav.zuban.testitrum.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
