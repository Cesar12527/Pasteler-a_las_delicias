<?php
require_once '../controllers/AuthController.php';

$authController = new AuthController();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $authController->login();
} else {
    $authController->showLogin();
}
?>