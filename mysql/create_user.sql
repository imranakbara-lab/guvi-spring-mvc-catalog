-- Local test user for this project (run once as root in MySQL Workbench)
CREATE USER IF NOT EXISTS 'guvi'@'localhost' IDENTIFIED BY 'guvi123';
GRANT ALL PRIVILEGES ON catalogdb.* TO 'guvi'@'localhost';
FLUSH PRIVILEGES;
