document.getElementById('registrazioneForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const response = await fetch('/api/auth/registrazione', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            username: document.getElementById('username').value,
            password: document.getElementById('password').value,
            ruolo: document.getElementById('ruolo').value
        })
    });

    if(response.ok) {
        alert('Registrazione completata!');
    } else {
        alert('Errore nella registrazione');
    }
});

document.getElementById('loginForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const response = await fetch('/api/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            username: document.getElementById('loginUsername').value,
            password: document.getElementById('loginPassword').value
        })
    });

    if(response.ok) {
        const utente = await response.json();
        localStorage.setItem('utente', JSON.stringify(utente));
        window.location.href = '/dashboard.html';
    } else {
        alert('Credenziali non valide');
    }
});