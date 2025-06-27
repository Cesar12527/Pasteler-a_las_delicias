<?php
require_once '../config/database.php';

class User {
    private $db;
    
    public function __construct() {
        $database = new Database();
        $this->db = $database->getConnection();
    }
    
    public function login($correo, $contraseña) {
        try {
            $query = "SELECT u.*, r.nombre as rol_nombre, e.nombre as escuela_nombre, f.nombre as facultad_nombre 
                     FROM usuarios u 
                     INNER JOIN roles r ON u.rol_id = r.id 
                     INNER JOIN escuelas e ON u.escuela_id = e.id 
                     INNER JOIN facultades f ON e.facultad_id = f.id 
                     WHERE u.correo = :correo";
            
            $stmt = $this->db->prepare($query);
            $stmt->bindParam(':correo', $correo);
            $stmt->execute();
            
            $user = $stmt->fetch();
            
            if ($user && password_verify($contraseña, $user['contraseña'])) {
                return $user;
            }
            
            // Verificación temporal para contraseña sin hash (mientras se migra)
            if ($user && $user['contraseña'] === $contraseña) {
                return $user;
            }
            
            return false;
        } catch (PDOException $e) {
            error_log("Error en login: " . $e->getMessage());
            return false;
        }
    }
    
    public function getUserById($id) {
        try {
            $query = "SELECT u.*, r.nombre as rol_nombre, e.nombre as escuela_nombre, f.nombre as facultad_nombre 
                     FROM usuarios u 
                     INNER JOIN roles r ON u.rol_id = r.id 
                     INNER JOIN escuelas e ON u.escuela_id = e.id 
                     INNER JOIN facultades f ON e.facultad_id = f.id 
                     WHERE u.id = :id";
            
            $stmt = $this->db->prepare($query);
            $stmt->bindParam(':id', $id);
            $stmt->execute();
            
            return $stmt->fetch();
        } catch (PDOException $e) {
            error_log("Error al obtener usuario: " . $e->getMessage());
            return false;
        }
    }
}
?>