<template>
  <div>
    <h1>Nos Produits Hardware</h1>
    <div class="products-grid">
      <div v-for="product in products" :key="product.id" class="card product-card">
        <div class="image-placeholder">Image de {{ product.name }}</div>
        
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

// example de produits
const products = ref([
  { id: 1, name: 'Tech Book Pro 14', category: 'Ordinateur', price: 1200 },
  { id: 2, name: 'Tech Deck', category: 'Console', price: 499 },
  { id: 3, name: 'Tech phone Emperador', category: 'Téléphone', price: 899 },
  { id: 4, name: 'Tech Tab Sama', category: 'Tablette', price: 650 },
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
.image-placeholder {
  width: 100%;
  height: 150px;
  background-color: #ddd;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #666;
  margin-bottom: 10px;
}
.price {
  font-weight: bold;
  color: #2c3e50;
  font-size: 1.2rem;
}
</style>