<template>
  <div>
    <h1>Mon Compte</h1>
    <div class="card">
      <div v-if="!isLoggedIn">
        <h2>Connexion</h2>
        <input type="text" placeholder="Nom d'utilisateur">
        <input type="password" placeholder="Mot de passe">
        <button @click="login">Se connecter</button>
      </div>
      <div v-else>
        <h2>Bonjour, Utilisateur !</h2>
        <p>Voici le contenu de votre panier :</p>
        <p><em>Votre panier est vide pour le moment.</em></p>
        <button @click="isLoggedIn = false" style="background-color: #e74c3c;">Se déconnecter</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const isLoggedIn = ref(false)

const login = () => {
  isLoggedIn.value = true
}
</script>