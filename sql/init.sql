CREATE TABLE example2_product(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    good_id BIGINT,
    good_name VARCHAR(255),
    num BIGINT,
    version int DEFAULT 0
);