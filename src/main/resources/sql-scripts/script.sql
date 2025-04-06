drop table if exists cliente;

CREATE TABLE cliente (
id BIGSERIAL PRIMARY KEY,
nombre VARCHAR(255),
genero VARCHAR(50),
fecha_nacimiento DATE,
identificacion VARCHAR(50),
direccion VARCHAR(255),
telefono VARCHAR(50),
clienteId VARCHAR(50),
clave VARCHAR(255),
estado VARCHAR(50)
);

INSERT INTO cliente (nombre, genero, fecha_nacimiento, identificacion, direccion, telefono, clienteId, clave, estado) VALUES
('Paul Atreides', UPPER('Male'), '1965-08-01', 'ID00123456', 'Arrakis', '555-1234', 'C001234567', MD5('password1'), UPPER('True')),
('Leia Organa', UPPER('Female'), '1956-10-21', 'ID00234567', 'Alderaan', '555-5678', 'C002345678', MD5('password2'), UPPER('True')),
('Ender Wiggin', UPPER('Male'), '1985-06-15', 'ID00345678', 'Battle School', '555-8765', 'C003456789', MD5('password3'), UPPER('True')),
('Arthur Dent', UPPER('Male'), '1979-03-11', 'ID00456789', 'Earth', '555-4321', 'C004567890', MD5('password4'), UPPER('True')),
('Katniss Everdeen', UPPER('Female'), '2008-09-14', 'ID00567890', 'District 12', '555-6789', 'C005678901', MD5('password5'), UPPER('True')),
('Rick Deckard', UPPER('Male'), '1968-01-01', 'ID00678901', 'San Francisco', '555-9876', 'C006789012', MD5('password6'), UPPER('True')),
('Neo', UPPER('Male'), '1999-03-31', 'ID00789012', 'Matrix', '555-1111', 'C007890123', MD5('password7'), UPPER('True')),
('Trillian', UPPER('Female'), '1979-03-11', 'ID00890123', 'Heart of Gold', '555-2222', 'C008901234', MD5('password8'), UPPER('True')),
('Gully Foyle', UPPER('Male'), '1956-01-01', 'ID00901234', 'Nomad', '555-3333', 'C009012345', MD5('password9'), UPPER('True')),
('Molly Millions', UPPER('Female'), '1984-07-01', 'ID01012345', 'Chiba City', '555-4444', 'C010123456', MD5('password10'), UPPER('True'));

select * from cliente;