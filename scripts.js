// scripts.js
document.addEventListener('DOMContentLoaded', function() {
    const mainContent = document.querySelector('main .content');
    
    // Add event listeners to navigation links
    const navLinks = document.querySelectorAll('nav ul li a');
    navLinks.forEach(link => {
        link.addEventListener('click', e => {
            e.preventDefault();
            const href = link.getAttribute('href');
            mainContent.classList.add('fade-out');
            setTimeout(() => {
                window.location.href = href;
            }, 500); // Match fade-out animation duration
        });
    });
    
    // Add class to main content for fade-in effect
    mainContent.classList.add('fade-in');
});
