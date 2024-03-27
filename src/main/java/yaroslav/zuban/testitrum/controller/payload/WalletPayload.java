package yaroslav.zuban.testitrum.controller.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import yaroslav.zuban.testitrum.enum_package.OperationType;

public record WalletPayload(
        @NotNull(message = "walled.errors.amount.null")
        Integer valletId,
        @NotNull(message = "walled.errors.operationType")
        OperationType operationType,

        @NotNull(message = "walled.errors.amount.null")
        @Min(value = 0, message = "walled.errors.amount")
        Double amount) {
}