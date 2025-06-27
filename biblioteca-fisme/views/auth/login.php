<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Biblioteca FISME</title>
    <link rel="stylesheet" href="../css/style.css">
</head>

<center>
<body class="login-body">
    <div class="login-container">
        <div class="login-card">
            <div class="login-header">
                <div class="university-logo">
                   
                </div>
                <h1>Biblioteca FISME</h1>
                <p>Universidad Nacional Toribio Rodríguez de Mendoza</p>
            </div>
            
            <?php if (isset($error)): ?>
                <div class="error-message">
                    <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                        <circle cx="12" cy="12" r="10"/>
                        <line x1="15" y1="9" x2="9" y2="15"/>
                        <line x1="9" y1="9" x2="15" y2="15"/>
                    </svg>
                    <?php echo htmlspecialchars($error); ?>
                </div>
            <?php endif; ?>
            
            <form method="POST" class="login-form">
                <div class="form-group">
                    <label for="correo">Correo Electrónico</label>
                    <div class="input-group">
                        
                        <input type="email" id="correo" name="correo" required placeholder="Tu correo institucional">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="contraseña">Contraseña</label>
                    <div class="input-group">
                        
                        <input type="password" id="contraseña" name="contraseña" required placeholder="Tu contraseña">
                    </div>
                </div>
                
                <button type="submit" class="login-btn">
                    <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                        <path d="M15 3h4a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2h-4"/>
                        <polyline points="10,17 15,12 10,7"/>
                        <line x1="15" y1="12" x2="3" y2="12"/>
                    </svg>
                    Iniciar Sesión
                </button>
            </form>
            
            <div class="login-footer">
                <p>¿Tienes problemas para acceder? Contacta al administrador</p>
            </div>
        </div>
    </div>
</body>
</center>
</html>