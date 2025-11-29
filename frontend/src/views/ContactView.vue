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

button {
  width: 100%;
  margin-top: 10px;
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