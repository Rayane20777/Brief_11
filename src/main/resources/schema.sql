-- Create Users table
CREATE TABLE users (
                       id CHAR(36) PRIMARY KEY,
                       login VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       active BOOLEAN NOT NULL
);

-- Create Roles table
CREATE TABLE roles (
                       id CHAR(36) PRIMARY KEY,
                       name VARCHAR(50) NOT NULL UNIQUE
);

-- Create User_Roles join table
CREATE TABLE user_roles (
                            user_id CHAR(36) NOT NULL,
                            role_id CHAR(36) NOT NULL,
                            PRIMARY KEY (user_id, role_id),
                            FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                            FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- Create Categories table
CREATE TABLE categories (
                            id CHAR(36) PRIMARY KEY,
                            name VARCHAR(100) NOT NULL UNIQUE,
                            description TEXT
);

-- Create Products table
CREATE TABLE products (
                          id CHAR(36) PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          price DECIMAL(10, 2) NOT NULL,
                          quantity INT NOT NULL,
                          category_id CHAR(36),
                          FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL
);

-- Insert default roles
INSERT INTO roles (id, name) VALUES
                                 (UUID(), 'ROLE_USER'),
                                 (UUID(), 'ROLE_ADMIN');

-- Insert a default admin user (password is 'admin' - make sure to change this in production!)
INSERT INTO users (id, login, email, password, active) VALUES
    (UUID(), 'admin', 'admin@example.com', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', true);

-- Assign admin role to the admin user
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u, roles r
WHERE u.login = 'admin' AND r.name = 'ROLE_ADMIN';

