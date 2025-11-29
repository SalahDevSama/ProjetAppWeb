import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useAuthStore = defineStore('auth', () => {

  const isLoggedIn = ref(localStorage.getItem('isLoggedIn') === 'true')
  const username = ref(localStorage.getItem('username') || '')
  
  function login(user) {
    isLoggedIn.value = true
    username.value = user

    localStorage.setItem('isLoggedIn', 'true')
    localStorage.setItem('username', user)
  }
  
  function logout() {
    isLoggedIn.value = false
    username.value = ''
 
    localStorage.removeItem('isLoggedIn')
    localStorage.removeItem('username')
  }
  
  return { 
    isLoggedIn, 
    username, 
    login, 
    logout 
  }
})