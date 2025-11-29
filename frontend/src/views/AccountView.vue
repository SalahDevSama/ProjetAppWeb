<template>
  <div>
    <h1>Mon Compte</h1>
    <div class="card">
      <div v-if="!isLoggedIn">
        <h2>Connexion</h2>
        <form @submit.prevent="login">
          <label for="username">Nom d'utilisateur</label>
          <input id="username" v-model="username" type="text" placeholder="Nom d'utilisateur" required>
          
          <label for="password">Mot de passe</label>
          <input id="password" v-model="password" type="password" placeholder="Mot de passe" required>
          
          <button type="submit">Se connecter</button>
        </form>
      </div>
      
      <div v-else>
        <h2>Bonjour, {{ username }} !</h2>
        
        <h3 style="margin-top: 30px;">Mon Panier ({{ cartStore.itemCount }})</h3>
        
        <div v-if="cartStore.items.length === 0" class="empty-cart">
          <p><em>Votre panier est vide pour le moment.</em></p>
        </div>
        
        <div v-else class="cart-items">
          <div v-for="item in cartStore.items" :key="item.id" class="cart-item">
            <div class="item-info">
              <img :src="item.image" :alt="item.name" class="item-image">
              <div>
                <h4>{{ item.name }}</h4>
                <p class="item-category">{{ item.category }}</p>
              </div>
            </div>
            
            <div class="item-controls">
              <div class="quantity-controls">
                <button @click="cartStore.updateQuantity(item.id, item.quantity - 1)" class="qty-btn">-</button>
                <span class="quantity">{{ item.quantity }}</span>
                <button @click="cartStore.updateQuantity(item.id, item.quantity + 1)" class="qty-btn">+</button>
              </div>
              
              <span class="item-price">{{ formatPrice(item.price * item.quantity) }}</span>
              
              <button @click="cartStore.removeItem(item.id)" class="btn-remove">
                Supprimer
              </button>
            </div>
          </div>
          
          <div class="cart-total">
            <h3>Total : {{ cartStore.formattedTotal }}</h3>
            <button @click="clearCart" class="btn-clear">Vider le panier</button>
          </div>
        </div>
        
        <button @click="logout" style="background-color: #e74c3c; margin-top: 20px;">
          Se déconnecter
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useCartStore } from '@/stores/cart'

const cartStore = useCartStore()
const isLoggedIn = ref(false)
const username = ref('')
const password = ref('')

const formatPrice = (price) => {
  return new Intl.NumberFormat('fr-FR', {
    style: 'currency',
    currency: 'EUR',
    minimumFractionDigits: 0
  }).format(price)
}

const login = () => {
  if (username.value && password.value) {
    isLoggedIn.value = true
  }
}

const logout = () => {
  isLoggedIn.value = false
  username.value = ''
  password.value = ''
}

const clearCart = () => {
  if (confirm('Voulez-vous vraiment vider votre panier ?')) {
    cartStore.clearCart()
  }
}
</script>

<style scoped>
label {
  display: block;
  margin-bottom: 5px;
  margin-top: 10px;
  font-weight: 600;
  font-size: 0.9rem;
  color: #374151;
}

.empty-cart {
  text-align: center;
  padding: 30px;
  color: #6b7280;
}

.cart-items {
  margin-top: 20px;
}

.cart-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 15px;
  border: 2px solid #f3f4f6;
  border-radius: 12px;
  margin-bottom: 15px;
  gap: 15px;
}

.item-info {
  display: flex;
  align-items: center;
  gap: 15px;
  flex: 1;
}

.item-image {
  width: 60px;
  height: 60px;
  object-fit: contain;
  background: #f9fafb;
  border-radius: 8px;
  padding: 5px;
}

.item-info h4 {
  margin: 0;
  font-size: 1rem;
}

.item-category {
  margin: 5px 0 0 0;
  font-size: 0.8rem;
  color: #9ca3af;
}

.item-controls {
  display: flex;
  align-items: center;
  gap: 20px;
}

.quantity-controls {
  display: flex;
  align-items: center;
  gap: 10px;
}

.qty-btn {
  width: 30px;
  height: 30px;
  padding: 0;
  border-radius: 50%;
  font-size: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
}

.quantity {
  min-width: 30px;
  text-align: center;
  font-weight: 600;
}

.item-price {
  font-weight: 700;
  font-size: 1.1rem;
  color: var(--primary-color);
  min-width: 100px;
  text-align: right;
}

.btn-remove {
  background-color: #ef4444;
  padding: 8px 16px;
  font-size: 0.85rem;
}

.btn-remove:hover {
  background-color: #dc2626;
}

.cart-total {
  margin-top: 30px;
  padding-top: 20px;
  border-top: 2px solid #e5e7eb;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.cart-total h3 {
  color: var(--primary-color);
  margin: 0;
}

.btn-clear {
  background-color: #6b7280;
}

.btn-clear:hover {
  background-color: #4b5563;
}
</style>