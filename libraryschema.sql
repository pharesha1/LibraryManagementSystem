USE `library_schema`;

-- Create the Books table
CREATE TABLE Books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) UNIQUE NOT NULL,
    available_copies INT,
    total_copies INT,
    -- Add indexes for efficient querying
    INDEX (isbn),
    INDEX (isbn, title)
);

-- Create the patrons table
CREATE TABLE Patrons (
    patron_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(15)
);

-- Create the Transactions table
CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    patron_id INT,
    borrow_date DATE,
    due_date DATE,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES Books(book_id),
    FOREIGN KEY (patron_id) REFERENCES Patrons(patron_id)
);

-- Sample data

INSERT INTO Books (book_id, title, author, genre, isbn, available_copies, total_copies) VALUES
(1, 'Book 1', 'Author 1', 'Fiction', '1234567890123', 5, 10),
(2, 'Book 2', 'Author 2', 'Science Fiction', '2345678901234', 3, 5);

INSERT INTO Patrons (patron_id, first_name, last_name, email, phone_number) VALUES
(1, 'John', 'Doe', 'john.doe@example.com', '123-456-7890'),
(2, 'Jane', 'Smith', 'jane.smith@example.com', '987-654-3210');