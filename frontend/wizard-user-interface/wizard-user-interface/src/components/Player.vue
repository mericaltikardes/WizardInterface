<template>
  <div>
    <div v-if="step === 1">
      <!-- Step 1 content -->
      <h1>Step 1: Caption Game Information</h1>
      <input type="text" placeholder="Enter Game Name" v-model="gameName" />
      <input
        type="text"
        placeholder="Enter game description"
        v-model="gameDescription"
      />
      <button @click="addGame">Next</button>
    </div>

    <div v-if="step === 2">
      <button @click="showPlayers" v-if="!playersVisible">Show Players</button>

      <!-- Step 2 content -->
      <div class="container" v-if="playersVisible">
        <h1 class="text-center">Players List</h1>
        <table class="table table-stripped">
          <thead>
            <tr>
              <th>Player Id</th>
              <th>Name</th>
              <th>Surname</th>
              <th>Birth City</th>
              <th>Birth Date</th>
              <th>Gender</th>
              <th>isActive</th>
              <th>Game Id</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="player in players" :key="player.id">
              <td>{{ player.id }}</td>
              <td>{{ player.name }}</td>
              <td>{{ player.surname }}</td>
              <td>{{ player.birthCity }}</td>
              <td>{{ player.birthDate }}</td>
              <td>{{ player.gender }}</td>
              <td>{{ player.isActive }}</td>
              <td>{{ player.Game }}</td>
            </tr>
          </tbody>
        </table>
      </div>

      <button @click="prevStep">Previous</button>
      <button @click="nextStep">Next</button>
      <div>
        <button @click="openAddPlayerModal">Yeni Oyuncu Ekle</button>
        <div v-if="showAddPlayerModal">
          <input v-model="newPlayer.name" placeholder="İsim" />
          <input v-model="newPlayer.surname" placeholder="Soyisim" />
          <input v-model="newPlayer.gender" placeholder="Cinsiyet" />
          <input v-model="newPlayer.birthDate" placeholder="Doğum Tarihi" />
          <input v-model="newPlayer.birthCity" placeholder="Doğum Şehri" />
          <button @click="addPlayer">Kaydet</button>
        </div>
      </div>
    </div>

    <div v-if="step === 3">
      <!-- Step 3 content -->
      <h1>Step 3: Actions</h1>
      <p>Name: {{ newPlayer.name }}</p>
      <input type="text" v-model="newPlayer.name" />
      <p>Surname: {{ newPlayer.surname }}</p>
      <input type="text" v-model="newPlayer.surname" />
      <p>Birth City: {{ newPlayer.birthCity }}</p>
      <input type="text" v-model="newPlayer.birthCity" />
      <button @click="prevStep">Previous</button>
      <button @click="validateStep3">Submit</button>
    </div>
  </div>
</template>

<script>
import PlayerServices from "../../services/PlayerServices";
import GameServices from "../../services/GameServices";
import axios from "axios";

export default {
  data() {
    return {
      step: 1,
      gameName: "",
      gameDescription: "",
      playersVisible: false,
      showAddPlayerModal: false,
      players: [],
      newPlayer: {
        id: 3,
        name: "",
        surname: "",
        gender: "",
        birthDate: "",
        birthCity: "",
        active: false,
      },
    };
  },
  methods: {
    validateStep1() {
      if (!this.gameName || !this.gameDescription) {
        alert("Please fill in all fields.");
      } else {
        this.nextStep();
      }
    },
    validateStep3() {
      if (
        !this.newPlayer.name ||
        !this.newPlayer.surname ||
        !this.newPlayer.birthCity
      ) {
        alert("Please fill in all fields.");
      } else {
        this.submitForm();
      }
    },

    nextStep() {
      this.step++;
    },
    showPlayers() {
      this.playersVisible = true;
    },
    prevStep() {
      this.step--;
    },
    submitForm() {
      // Perform form submission logic here
      // e.g., make an API request, save data, etc.
      console.log("Form submitted!");
    },
    getPlayers() {
      PlayerServices.getPlayers().then((response) => {
        this.players = response.data;
      });
    },
  },
  created() {
    this.getPlayers();
  },
  addGame() {
    const gameData = {
      name: this.gameName,
      description: this.gameDescription,
    };
    GameServices.addGame(gameData)
      .then((response) => {
        console.log(response);

        this.nextStep();
      })
      .catch((error) => {
        console.error(error);
      });
  },
};
</script>
