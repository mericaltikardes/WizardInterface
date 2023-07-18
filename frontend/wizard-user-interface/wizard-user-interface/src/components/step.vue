<template>
  <div>
    <div v-if="step === 1">
      <!-- Step 1 content -->
      <h1>Step 1: Enter your name</h1>
      <input type="text" v-model="name" />
      <button @click="nextStep">Next</button>
    </div>

    <div v-if="step === 2">
      <!-- Step 2 content -->
      <h1>Step 2: Enter your email</h1>
      <input type="email" v-model="email" />
      <button @click="prevStep">Previous</button>
      <button @click="nextStep">Next</button>
    </div>

    <div v-if="step === 3">
      <!-- Step 3 content -->
      <h1>Step 3: Confirmation</h1>
      <p>Name: {{ name }}</p>
      <p>Email: {{ email }}</p>
      <button @click="prevStep">Previous</button>
      <button @click="submitForm">Submit</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      step: 1,
      name: "",
      email: "",
    };
  },
  methods: {
    nextStep() {
      this.step++;
    },
    prevStep() {
      this.step--;
    },
    submitForm() {
      // Perform form submission logic here
      // e.g., make an API request, save data, etc.
      console.log("Form submitted!");
    },
  },
};
</script>
