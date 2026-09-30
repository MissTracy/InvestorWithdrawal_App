-- also removed duplicates on restart for Jane Smith or duplicate products.

-- Insert Investor data
INSERT INTO investor (
    name, 
    surname, 
    date_of_birth, 
    home_address, 
    phone_number, 
    email_address)
SELECT
    'Jane',
    'Smith',
    '1988-08-29',
    '888 high street Sandstone',
    '065-123-4567',
    'jane@gmail.com'
WHERE NOT EXISTS (
    SELECT 1
    FROM investor
    WHERE email_address = 'jane@gmail.com'
);

-- Insert Product data
INSERT INTO products (
    product_name, 
    balance, 
    product_type, 
    investor_id)
SELECT
    'RETIREMENT',
    500000.00,
    'RETIREMENT',
    id
FROM investor
WHERE email_address = 'jane@gmail.com'
  AND NOT EXISTS (
      SELECT 1
      FROM products
      WHERE product_name = 'RETIREMENT'
        AND investor_id = investor.id
  );

INSERT INTO products (
    product_name, 
    balance, 
    product_type, 
    investor_id)
SELECT
    'SAVINGS',
    36000.00,
    'SAVINGS',
    id
FROM investor
WHERE email_address = 'jane@gmail.com'
  AND NOT EXISTS (
      SELECT 1
      FROM products
      WHERE product_name = 'SAVINGS'
        AND investor_id = investor.id
  );

