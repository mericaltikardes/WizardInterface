import axios from "axios";

const GAME_SERVİCES_BASE_URL = "http://localhost:8080/games";

class GameServices {
  getGames() {
    return axios.get(GAME_SERVİCES_BASE_URL);
  }
  addGame(gameData) {
    return axios.post(GAME_SERVİCES_BASE_URL, gameData);
  }
}

export default new GameServices();
