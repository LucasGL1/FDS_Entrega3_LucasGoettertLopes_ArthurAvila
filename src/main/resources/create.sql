-- Remove a tabela se ela já existir, para garantir que estamos começando do zero
DROP TABLE IF EXISTS livros;

-- Cria a tabela 'livros' com as colunas correspondentes à classe Livro
CREATE TABLE livros (
  id INT PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  autor VARCHAR(255) NOT NULL,
  ano INT NOT NULL
);