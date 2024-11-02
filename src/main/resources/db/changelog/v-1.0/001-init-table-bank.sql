INSERT INTO bank (id, type_shop, balance, last_operation_bonus, total_bonus_account, commission)
VALUES (md5(random()::text)::uuid, 'online', 5000, 0, 0, 0),
       (md5(random()::text)::uuid, 'shop', 5000, 0, 0, 0);