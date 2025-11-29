import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useCartStore = defineStore('cart', () => {
  const items = ref([])
  
  const total = computed(() => 
    items.value.reduce((sum, item) => sum + item.price * item.quantity, 0)
  )
  
  const itemCount = computed(() => 
    items.value.reduce((sum, item) => sum + item.quantity, 0)
  )
  
  const formattedTotal = computed(() => {
    return new Intl.NumberFormat('fr-FR', {
      style: 'currency',
      currency: 'EUR'
    }).format(total.value)
  })
  
  function addItem(product) {
    const existing = items.value.find(i => i.id === product.id)
    if (existing) {
      existing.quantity++
    } else {
      items.value.push({ ...product, quantity: 1 })
    }
  }
  
  function removeItem(productId) {
    const index = items.value.findIndex(i => i.id === productId)
    if (index > -1) items.value.splice(index, 1)
  }
  
  function updateQuantity(productId, quantity) {
    const item = items.value.find(i => i.id === productId)
    if (item && quantity > 0) {
      item.quantity = quantity
    } else if (quantity === 0) {
      removeItem(productId)
    }
  }
  
  function clearCart() {
    items.value = []
  }
  
  return { 
    items, 
    total, 
    itemCount, 
    formattedTotal,
    addItem, 
    removeItem, 
    updateQuantity,
    clearCart 
  }
})