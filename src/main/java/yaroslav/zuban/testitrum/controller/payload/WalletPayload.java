package yaroslav.zuban.testitrum.controller.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;
import yaroslav.zuban.testitrum.entity.OperationType;

public record WalletPayload(
        @NotNull(message = "walled.errors.amount.null")
        Integer valletId,
        @NotNull(message = "walled.errors.operationType")
        OperationType operationType,

        @NotNull(message = "walled.errors.amount.null")
        @Min(value = 0, message = "walled.errors.amount")
        Double amount) {
}