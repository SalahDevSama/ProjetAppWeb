<template>
  <div class="contact-page">
    <h1>Nous Contacter</h1>
    <p>Remplissez ce formulaire. Vos données seront sauvegardées sur nos serveurs sécurisés.</p>

    <div class="card">
      <form @submit.prevent="submitForm">
        <label>Nom complet :</label>
        <input v-model="formData.name" type="text" required placeholder="Prenom Nom">

        <label>Email :</label>
        <input v-model="formData.email" type="email" required placeholder="exemple@exemple.com">

        <label>Sujet :</label>
        <input v-model="formData.subject" type="text" required placeholder="Demande de devis">

        <label>Message :</label>
        <textarea v-model="formData.message" rows="5" required placeholder="Votre message..."></textarea>

        <button type="submit">Envoyer le message</button>
      </form>
    </div>
    
    <div v-if="statusMessage" :class="{'success': isSuccess, 'error': !isSuccess}">
      {{ statusMessage }}
    </div>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue'

const formData = reactive({
  name: '',
  email: '',
  subject: '',
  message: ''
})

const statusMessage = ref('')
const isSuccess = ref(false)

const submitForm = async () => {
  console.log("Données à envoyer au backend :", formData)
  
  statusMessage.value = "Envoi en cours..."
  
  setTimeout(() => {
    isSuccess.value = true
    statusMessage.value = "Message enregistré avec succès !"
    // Reset du formulaire
    formData.name = ''
    formData.email = ''
    formData.subject = ''
    formData.message = ''
  }, 1000)
}
</script>

<style scoped>
.success { color: green; margin-top: 10px; font-weight: bold; }
.error { color: red; margin-top: 10px; font-weight: bold; }
</style>