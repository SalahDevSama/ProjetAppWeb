<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <div class="wrapper">
      <nav>
        <RouterLink to="/">Accueil</RouterLink>
        <RouterLink to="/products">Nos Produits</RouterLink>
        <RouterLink to="/contact">Contact</RouterLink>
        <RouterLink to="/account">Mon Compte</RouterLink>
      </nav>
    </div>
  </header>

  <main class="container">
    <RouterView />
  </main>
</template>

<style src="./assets/base.css"></style>