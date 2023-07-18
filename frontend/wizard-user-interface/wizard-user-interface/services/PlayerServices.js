import axios from "axios";

const PLAYER_SERVİCES_BASE_URL = "http://localhost:8080/players/1";

class PlayerServices {
  getPlayers() {
    return axios.get(PLAYER_SERVİCES_BASE_URL);
  }
  addPlayer(playerData) {
    return axios.post(PLAYER_SERVİCES_BASE_URL, playerData);
  }
}

export default new PlayerServices();
