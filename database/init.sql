CREATE TABLE IF NOT EXISTS contact_messages (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    subject VARCHAR(200),
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- test
INSERT INTO contact_messages (name, email, subject, message)
VALUES ('Test User', 'test@techhardware.com', 'Test de connexion', 'msg test bjr tout le monde !');