import React from 'react';
import './App.css';
import { listOfPlayers as ListOfPlayers, below70Players as Below70Players, players } from './ListofPlayers';
import { OddPlayers, EvenPlayers, IndianPlayers, IndianTeam, IndianPlayersMerged } from './ListofPlayers2';

function App() {
    return (
      <div className="App" style={{ textAlign: 'left', padding: '20px' }}>
        <ListOfPlayers players={players} />
        <hr />
        <Below70Players players={players} />
        <hr />
        {OddPlayers(IndianTeam)}
        <hr />
        {EvenPlayers(IndianTeam)}
        <hr />
        <h1>List of Indian Players Merged:</h1>
        <IndianPlayers IndianPlayers={IndianPlayersMerged} />
      </div>  
    );
  }
export default App;