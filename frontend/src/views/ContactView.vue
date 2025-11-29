<template>
  <div class="contact-page">
    <h1>Nous Contacter</h1>
    <p>Remplissez ce formulaire, pour nous envoyer un message.</p>

    <div class="card">
      <form @submit.prevent="submitForm">
        <label for="name">Nom complet :</label>
        <input 
          id="name"
          v-model="formData.name" 
          type="text" 
          required 
          minlength="3"
          placeholder="Prénom Nom"
        >

        <label for="email">Email :</label>
        <input 
          id="email"
          v-model="formData.email" 
          type="email" 
          required 
          placeholder="exemple@exemple.com"
          @blur="validateEmail"
        >
        <span v-if="emailError" class="error-text">{{ emailError }}</span>

        <label for="subject">Sujet :</label>
        <input 
          id="subject"
          v-model="formData.subject" 
          type="text" 
          required 
          minlength="5"
          placeholder="Demande de devis"
        >

        <label for="message">Message :</label>
        <textarea 
          id="message"
          v-model="formData.message" 
          rows="5" 
          required 
          minlength="10"
          placeholder="Votre message ..."
        ></textarea>

        <button type="submit" :disabled="!!emailError">Envoyer le message</button>
      </form>
    </div>
    
    <div v-if="statusMessage" :class="{'success': isSuccess, 'error': !isSuccess}">
      {{ statusMessage }}
    </div>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue'
import axios from 'axios'

const formData = reactive({
  name: '',
  email: '',
  subject: '',
  message: ''
})

const statusMessage = ref('')
const isSuccess = ref(false)
const emailError = ref('')

const validateEmail = () => {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
  if (formData.email && !emailRegex.test(formData.email)) {
    emailError.value = 'Adresse email invalide'
  } else {
    emailError.value = ''
  }
}

const submitForm = async () => {
  if (!formData.name || formData.name.length < 3) {
    statusMessage.value = "Le nom doit contenir au moins 3 caractères"
    isSuccess.value = false
    return
  }
  
  if (!formData.message || formData.message.length < 10) {
    statusMessage.value = "Le message doit contenir au moins 10 caractères"
    isSuccess.value = false
    return
  }
  
  if (emailError.value) {
    return
  }
  
  console.log("Données à envoyer au backend : ", formData)

  statusMessage.value = "Envoi en cours..."

  axios.post('http://localhost:8081/send', formData)
    .then(response => {
      isSuccess.value = true
      statusMessage.value = "Message envoyé avec succès !"
      
      // reset du formulaire
      formData.name = ''
      formData.email = ''
      formData.subject = ''
      formData.message = ''
      emailError.value = ''
      
      setTimeout(() => {
        statusMessage.value = ''
      }, 5000)
    })
    .catch(error => {
      isSuccess.value = false
      statusMessage.value = "Erreur lors de l'envoi du message. Veuillez réessayer plus tard."
      console.error("Erreur lors de l'envoi du message : ", error)
    })
}
</script>

<style scoped>
.contact-page {
  max-width: 600px;
  margin: 0 auto;
}

h1 { text-align: center; }
p { text-align: center; color: #6b7280; margin-bottom: 2rem; }

label {
  display: block;
  margin-bottom: 5px;
  font-weight: 600;
  font-size: 0.9rem;
  color: #374151;
}

.error-text {
  display: block;
  color: #ef4444;
  font-size: 0.85rem;
  margin-top: -10px;
  margin-bottom: 10px;
}

button {
  width: 100%;
  margin-top: 10px;
}

button:disabled {
  background-color: #9ca3af;
  cursor: not-allowed;
}

button:disabled:hover {
  transform: none;
  box-shadow: none;
}

.success {
  background-color: #d1fae5;
  color: #065f46;
  padding: 15px;
  border-radius: 8px;
  text-align: center;
  margin-top: 20px;
}

.error {
  background-color: #fee2e2;
  color: #991b1b;
  padding: 15px;
  border-radius: 8px;
  text-align: center;
  margin-top: 20px;
}
</style>