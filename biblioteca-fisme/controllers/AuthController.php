<?php
session_start();
require_once '../models/User.php';

class AuthController {
    private $userModel;
    
    public function __construct() {
        $this->userModel = new User();
    }
    
    public function showLogin() {
        // Si ya está logueado, redirigir al dashboard
        if (isset($_SESSION['user_id'])) {
            $this->redirectToDashboard();
            return;
        }
        
        include '../views/auth/login.php';
    }
    
    public function login() {
        if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
            header('Location: login.php');
            return;
        }
        
        $correo = trim($_POST['correo'] ?? '');
        $contraseña = trim($_POST['contraseña'] ?? '');
        
        if (empty($correo) || empty($contraseña)) {
            $error = "Por favor, complete todos los campos";
            include '../views/auth/login.php';
            return;
        }
        
        $user = $this->userModel->login($correo, $contraseña);
        
        if ($user) {
            // Iniciar sesión
            $_SESSION['user_id'] = $user['id'];
            $_SESSION['user_name'] = $user['nombre_completo'];
            $_SESSION['user_email'] = $user['correo'];
            $_SESSION['user_role'] = $user['rol_nombre'];
            $_SESSION['user_role_id'] = $user['rol_id'];
            $_SESSION['user_school'] = $user['escuela_nombre'];
            $_SESSION['user_faculty'] = $user['facultad_nombre'];
            
            $this->redirectToDashboard();
        } else {
            $error = "Credenciales incorrectas";
            include '../views/auth/login.php';
        }
    }
    
    public function logout() {
        session_destroy();
        header('Location: login.php');
    }
    
    private function redirectToDashboard() {
        if ($_SESSION['user_role_id'] == 1) {
            // Bibliotecario
            header('Location: dashboard/bibliotecario.php');
        } else {
            // Usuario general
            header('Location: dashboard/usuario.php');
        }
    }
}
?>