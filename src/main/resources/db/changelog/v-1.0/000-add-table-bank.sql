CREATE TABLE IF NOT EXISTS bank
(
    id UUID PRIMARY KEY,
    type_shop TEXT,
    balance DECIMAL,
    last_operation_bonus DECIMAL,
    total_bonus_account DECIMAL,
    commission DECIMAL
);