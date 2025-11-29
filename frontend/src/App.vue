<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <div class="wrapper">
      <div class="logo">TechHardware</div>
      <nav>
        <RouterLink to="/">Accueil</RouterLink>
        <RouterLink to="/products">Produits</RouterLink>
        <RouterLink to="/contact">Contact</RouterLink>
        <RouterLink to="/account" class="btn-account">Compte</RouterLink>
      </nav>
    </div>
  </header>

  <main class="container">
    <RouterView />
  </main>
</template>

<style scoped>
header {
  background-color: white;
  padding: 1rem 0;
  box-shadow: 0 2px 10px rgba(0,0,0,0.05);
  position: sticky;
  top: 0;
  z-index: 100;
}

.wrapper {
  max-width: 1100px;
  margin: 0 auto;
  padding: 0 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  font-weight: 800;
  font-size: 1.5rem;
  color: var(--primary-color);
  letter-spacing: -1px;
}

nav a {
  text-decoration: none;
  color: #4b5563;
  margin-left: 20px;
  font-weight: 500;
  transition: color 0.3s;
}

nav a:hover, nav a.router-link-active {
  color: var(--primary-color);
}

.btn-account {
  background-color: #eff6ff;
  color: var(--primary-color) !important;
  padding: 8px 16px;
  border-radius: 8px;
}

.btn-account:hover {
  background-color: var(--primary-color);
  color: white !important;
}
</style>