CREATE DATABASE shopapp; USE
    shopapp;
CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(100) DEFAULT '',
    phone_number VARCHAR(10) NOT NULL,
    address VARCHAR(200) DEFAULT '',
    PASSWORD VARCHAR(100) NOT NULL DEFAULT '',
    created_at DATETIME,
    updated_at DATETIME,
    is_active TINYINT(1) DEFAULT 1,
    date_of_birth DATE,
    facebook_account_id INT DEFAULT 0,
    google_account_id INT DEFAULT 0
); CREATE TABLE roles(
    id INT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
); ALTER TABLE
    users ADD COLUMN role_id INT;
ALTER TABLE
    users ADD FOREIGN KEY(role_id) REFERENCES roles(id);
CREATE TABLE tokens(
    id INT PRIMARY KEY AUTO_INCREMENT,
    token VARCHAR(255) UNIQUE NOT NULL,
    token_type VARCHAR(50) NOT NULL,
    expiration_date DATETIME,
    revoked TINYINT(1) NOT NULL,
    expired TINYINT(1) NOT NULL,
    user_id INT,
    FOREIGN KEY(user_id) REFERENCES users(id)
);
-- Hỗ trợ đăng nhập bằng FB, GG
CREATE TABLE social_accounts(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `provider` VARCHAR(20) NOT NULL COMMENT 'Tên nhà social network',
    `provider_id` VARCHAR(150) NOT NULL,
    `email` VARCHAR(150) NOT NULL COMMENT 'Email tài khoản',
    `name` VARCHAR(100) NOT NULL COMMENT 'Tên người dùng',
    user_id INT,
    FOREIGN KEY(user_id) REFERENCES users(id)
); CREATE TABLE categories(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'Tên danh mục, vd: Đồ điện tử'
); CREATE TABLE products(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(350) COMMENT "Tên sản phẩm",
    thumbnail VARCHAR(255),
    price FLOAT NOT NULL CHECK
        (price >= 0),
        description LONGTEXT DEFAULT '',
        created_at DATETIME,
        updated_at DATETIME,
        category_id INT,
        FOREIGN KEY(category_id) REFERENCES categories(id)
);
CREATE TABLE product_images(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    FOREIGN KEY (product_id) REFERENCES products(id),
    CONSTRAINT fk_product_images_product_id
        FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE,
    url VARCHAR(100) DEFAULT ''
);
CREATE TABLE orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    FOREIGN KEY(user_id) REFERENCES users(id),
    fullname VARCHAR(100) DEFAULT '',
    `email` VARCHAR(150) DEFAULT '',
    phone_number VARCHAR(10) NOT NULL,
    address VARCHAR(255) NOT NULL,
    note VARCHAR(255) DEFAULT '',
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    STATUS ENUM
        (
            'pending',
            'processing',
            'shipped',
            'delivered',
            'cancelled'
        ) COMMENT 'Trạng thái của đơn hàng',
        total_money FLOAT
    CHECK
        (total_money >= 0),
        active TINYINT(1) DEFAULT 1,
        `shipping_method` VARCHAR(100),
        `shipping_address` VARCHAR(200),
        `shipping_date` DATE,
        `tracking_number` VARCHAR(100),
        `payment_method` VARCHAR(100)
);
CREATE TABLE order_details(
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    FOREIGN KEY(order_id) REFERENCES orders(id),
    product_id INT,
    FOREIGN KEY(product_id) REFERENCES products(id),
    price FLOAT CHECK
        (price >= 0),
        number_of_products INT
    CHECK
        (number_of_products > 0),
        total_money FLOAT
    CHECK
        (total_money >= 0),
        color VARCHAR(20) DEFAULT ''
);