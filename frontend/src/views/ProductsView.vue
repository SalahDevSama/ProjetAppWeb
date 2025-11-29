<template>
  <div>
    <h1>Nos Produits</h1>
    <p class="subtitle">Le meilleur du hardware, sélectionné pour vous.</p>
    
    <div class="products-grid">
      <div v-for="product in products" :key="product.id" class="card product-card">
        <div class="img-container">
          <img :src="product.image" :alt="product.name" class="product-image" loading="lazy">
        </div>
        
        <div class="card-content">
          <span class="category">{{ product.category }}</span>
          <h3>{{ product.name }}</h3>
          <div class="bottom-info">
            <span class="price">{{ formatPrice(product.price) }}</span>
            <button class="btn-add" @click="addToCart(product)">
              + Panier
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useCartStore } from '@/stores/cart'

const cartStore = useCartStore()

const products = ref([
  { id: 1, name: 'Tech Book Pro 14', category: 'Ordinateur', price: 1200, image: '/images/pc.png' },
  { id: 2, name: 'Tech Deck', category: 'Console', price: 499, image: '/images/console.png' },
  { id: 3, name: 'Tech Phone Emperador', category: 'Téléphone', price: 899, image: '/images/phone.png' },
  { id: 4, name: 'Tech Tab Sama', category: 'Tablette', price: 650, image: '/images/tab.png' },
])

const formatPrice = (price) => {
  return new Intl.NumberFormat('fr-FR', {
    style: 'currency',
    currency: 'EUR',
    minimumFractionDigits: 0
  }).format(price)
}

const addToCart = (product) => {
  cartStore.addItem(product)
  alert(`${product.name} ajouté au panier !`)
}
</script>

<style scoped>
.subtitle {
  color: #6b7280;
  margin-bottom: 2rem;
  text-align: center;
}

.products-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(240px, 1fr));
  gap: 30px;
}

.product-card {
  display: flex;
  flex-direction: column;
}

.product-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 20px rgba(0,0,0,0.1);
}

.img-container {
  height: 180px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 15px;
  background: #f9fafb;
  border-radius: 12px;
  padding: 10px;
}

.product-image {
  max-width: 100%;
  max-height: 100%;
  object-fit: contain;
}

.card-content {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

.category {
  font-size: 0.8rem;
  color: #9ca3af;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-weight: 600;
}

.product-card h3 {
  margin: 5px 0 15px 0;
  font-size: 1.1rem;
}

.bottom-info {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: auto;
}

.price {
  font-weight: 800;
  font-size: 1.3rem;
  color: var(--primary-color);
}

.btn-add {
  padding: 8px 16px;
  font-size: 0.8rem;
  border-radius: 20px;
}
</style>