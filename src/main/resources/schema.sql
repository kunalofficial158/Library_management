CREATE TABLE app_user (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(255),
    isbn VARCHAR(13),
    publication_date DATE,
    rating DOUBLE PRECISION
);

CREATE TABLE rental (
    id SERIAL PRIMARY KEY,
    rental_date TIMESTAMP,
    return_date TIMESTAMP,
    rental_fee DOUBLE PRECISION,
    user_id BIGINT,
    book_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES app_user(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);

CREATE TABLE review (
    id SERIAL PRIMARY KEY,
    review_text TEXT,
    rating DOUBLE PRECISION,
    book_id BIGINT,
    user_id BIGINT,
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (user_id) REFERENCES app_user(id)
);
