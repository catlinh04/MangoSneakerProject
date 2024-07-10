USE MangoSneakerDB;

INSERT INTO Category (CategoryName) VALUES ('Nike');
INSERT INTO Category (CategoryName) VALUES ('Adidas');
INSERT INTO Category (CategoryName) VALUES ('Converse');

INSERT INTO Customer (FirstName, LastName, Mail, Username, Password, Phone) VALUES
('John', 'Doe', 'john@example.com', 'johndoe', 'password1', '0123456789'),
('Jane', 'Smith', 'jane@example.com', 'janesmith', 'password2', '0283847625'),
('Alice', 'Johnson', 'alice@example.com', 'alicejohnson', 'password3', '092837423'),
('Bob', 'Brown', 'bob@example.com', 'bobbrown', 'password4', '0192837465'),
('Charlie', 'Davis', 'charlie@example.com', 'charliedavis', 'password5', '0394820283'),
('David', 'Evans', 'david@example.com', 'davidevans', 'password6', '0394820839'),
('Eve', 'Wilson', 'eve@example.com', 'evewilson', 'password7', '0394039482'),
('Frank', 'Miller', 'frank@example.com', 'frankmiller', 'password8', '0538945220'),
('Grace', 'Moore', 'grace@example.com', 'gracemoore', 'password9', '0425849302'),
('Hank', 'Taylor', 'hank@example.com', 'hanktaylor', 'password10', '0495039482'),
('Ivy', 'Anderson', 'ivy@example.com', 'ivyanderson', 'password11', '0492837503'),
('Jack', 'Thomas', 'jack@example.com', 'jackthomas', 'password12', '0657483903'),
('Kathy', 'Jackson', 'kathy@example.com', 'kathyjackson', 'password13', '0887888930'),
('Leo', 'White', 'leo@example.com', 'leowhite', 'password14', '0999857466'),
('Mona', 'Martin', 'mona@example.com', 'monamartin', 'password15', '0111118273');

INSERT INTO Product (CategoryID, ProductName, Price, [Image], Discount) VALUES
(1, 'Nike Air Max', 150.00, 'nike_air_max.jpg', 10.0),
(1, 'Nike Revolution', 120.00, 'nike_revolution.jpg', 5.0),
(2, 'Adidas Ultraboost', 180.00, 'adidas_ultraboost.jpg', 15.0),
(2, 'Adidas Superstar', 110.00, 'adidas_superstar.jpg', 8.0),
(3, 'Converse Chuck Taylor', 70.00, 'converse_chuck_taylor.jpg', 12.0),
(3, 'Converse All Star', 75.00, 'converse_all_star.jpg', 10.0),
(1, 'Nike Pegasus', 130.00, 'nike_pegasus.jpg', 7.0),
(1, 'Nike Cortez', 90.00, 'nike_cortez.jpg', 10.0),
(2, 'Adidas NMD', 140.00, 'adidas_nmd.jpg', 5.0),
(2, 'Adidas Stan Smith', 95.00, 'adidas_stan_smith.jpg', 12.0),
(3, 'Converse One Star', 85.00, 'converse_one_star.jpg', 8.0),
(3, 'Converse Pro Leather', 100.00, 'converse_pro_leather.jpg', 10.0),
(1, 'Nike Vapormax', 200.00, 'nike_vapormax.jpg', 15.0),
(2, 'Adidas Gazelle', 85.00, 'adidas_gazelle.jpg', 10.0),
(3, 'Converse Jack Purcell', 95.00, 'converse_jack_purcell.jpg', 5.0);

INSERT INTO [Order] (CustomerID, [Date]) VALUES
(1, '2024-05-01'),
(2, '2024-05-02'),
(3, '2024-05-03'),
(4, '2024-05-04'),
(5, '2024-05-05'),
(6, '2024-05-06'),
(7, '2024-05-07'),
(8, '2024-05-08'),
(9, '2024-05-09'),
(10, '2024-05-10'),
(11, '2024-05-11'),
(12, '2024-05-12'),
(13, '2024-05-13'),
(14, '2024-05-14'),
(15, '2024-05-15');

INSERT INTO OrderDetail (OrderID, ProductID, Quantity, UnitPrice) VALUES
(1, 1, 2, 150.00),
(2, 3, 1, 180.00),
(3, 5, 3, 70.00),
(4, 7, 1, 130.00),
(5, 9, 2, 140.00),
(6, 11, 1, 85.00),
(7, 13, 2, 200.00),
(8, 2, 1, 120.00),
(9, 4, 3, 110.00),
(10, 6, 2, 75.00),
(11, 8, 1, 90.00),
(12, 10, 2, 95.00),
(13, 12, 1, 100.00),
(14, 14, 1, 85.00),
(15, 15, 2, 95.00);

INSERT INTO CartDetail (CustomerID, ProductID, Quantity) VALUES
(1, 1, 2),
(2, 3, 1),
(3, 5, 3),
(4, 7, 1),
(5, 9, 2),
(6, 11, 1),
(7, 13, 2),
(8, 2, 1),
(9, 4, 3),
(10, 6, 2),
(11, 8, 1),
(12, 10, 2),
(13, 12, 1),
(14, 14, 1),
(15, 15, 2);

INSERT INTO Size (SizeNumber) VALUES
(36), (37), (38), (39), (40)

INSERT INTO ProductSize (ProductID, SizeNumber, Quantity) VALUES
(1, 36, 5), (1, 37, 10), (1, 38, 1), (1, 39, 1), (1, 40, 4),
(2, 36, 7), (2, 37, 3), (2, 38, 6), (2, 39, 8), (2, 40, 2),
(3, 36, 4), (3, 37, 9), (3, 38, 7), (3, 39, 2), (3, 40, 5),
(4, 36, 1), (4, 37, 8), (4, 38, 4), (4, 39, 10), (4, 40, 3),
(5, 36, 9), (5, 37, 6), (5, 38, 1), (5, 39, 3), (5, 40, 7),
(6, 36, 2), (6, 37, 4), (6, 38, 8), (6, 39, 9), (6, 40, 6),
(7, 36, 5), (7, 37, 1), (7, 38, 10), (7, 39, 7), (7, 40, 2),
(8, 36, 3), (8, 37, 9), (8, 38, 2), (8, 39, 6), (8, 40, 4),
(9, 36, 8), (9, 37, 7), (9, 38, 3), (9, 39, 1), (9, 40, 5),
(10, 36, 6), (10, 37, 10), (10, 38, 5), (10, 39, 4), (10, 40, 9),
(11, 36, 2), (11, 37, 7), (11, 38, 6), (11, 39, 8), (11, 40, 3),
(12, 36, 5), (12, 37, 4), (12, 38, 1), (12, 39, 9), (12, 40, 7),
(13, 36, 10), (13, 37, 3), (13, 38, 8), (13, 39, 2), (13, 40, 6),
(14, 36, 7), (14, 37, 1), (14, 38, 9), (14, 39, 4), (14, 40, 5),
(15, 36, 8), (15, 37, 10), (15, 38, 2), (15, 39, 5), (15, 40, 3);


SELECT * FROM Category
SELECT * FROM Customer
SELECT * FROM [Order]
SELECT * FROM Product
SELECT * FROM CartDetail
SELECT * FROM OrderDetail