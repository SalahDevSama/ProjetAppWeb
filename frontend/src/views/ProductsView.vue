<template>
  <div>
    <h1>Nos Produits Hardware</h1>
    <div class="products-grid">
      <div v-for="product in products" :key="product.id" class="card product-card">
        <img :src="product.image" :alt="product.name" class="product-image">
        
        <h3>{{ product.name }}</h3>
        <p>Catégorie : {{ product.category }}</p>
        <p class="price">{{ product.price }} €</p>
        <button @click="addToCart(product)">Ajouter au panier</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

// example de produit
const products = ref([
  { id: 1, name: 'Tech Book Pro 14', category: 'Ordinateur', price: 1200, image: '/images/pc.png' },
  { id: 2, name: 'Tech Deck', category: 'Console', price: 499, image: '/images/console.png' },
  { id: 3, name: 'Tech phone Emperador', category: 'Téléphone', price: 899, image: '/images/phone.png' },
  { id: 4, name: 'Tech Tab Sama', category: 'Tablette', price: 650, image: '/images/tab.png' },
])

const addToCart = (product) => {
  alert(`${product.name} ajouté au panier !`)
  // plus tard connection au store Pinia
}
</script>

<style scoped>
.products-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 20px;
}
.product-image {
  width: 100%;
  height: 150px;
  object-fit: cover;
  margin-bottom: 10px;
  border-radius: 8px;
}
.price {
  font-weight: bold;
  color: #2c3e50;
  font-size: 1.2rem;
}
</style>