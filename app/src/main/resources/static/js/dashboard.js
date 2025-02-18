document.addEventListener('DOMContentLoaded', () => {
    const utente = JSON.parse(localStorage.getItem('utente'));
    if(!utente) window.location.href = '/';

    document.getElementById('username').textContent = utente.username;
    document.getElementById('ruolo').textContent = utente.role;
});

function logout() {
    localStorage.removeItem('utente');
    window.location.href = '/';
}
