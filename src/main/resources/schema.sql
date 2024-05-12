CREATE TABLE IF NOT EXISTS `card`(
    `card_id` INT NOT NULL AUTO_INCREMENT,
    `mobile_number` VARCHAR(15) NOT NULL,
    `card_number` VARCHAR(100) NOT NULL UNIQUE,
    `card_type` VARCHAR(100) NOT NULL,
    `total_limit` INT NOT NULL,
    `amount_used` INT NOT NULL,
    `available_amount` INT NOT NULL,
    `created_at` DATE NOT NULL,
    `created_by` VARCHAR(20) NOT NULL,
    `updated_at` DATE,
    `updated_by` VARCHAR(20),
    PRIMARY KEY(`card_id`)
);