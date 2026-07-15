const IndianTeam = ['Sachin1', 'Dhoni2', 'Virat3', 'Rohit4', 'Yuvaraj5', 'Raina6'];

const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];

const IndianPlayersMerged = [...T20Players, ...RanjiTrophyPlayers];

function OddPlayers([first, , third, , fifth]) {
    return (
        <div>
            <h1>Odd Players</h1>
            <div>
                <li>First : {first}</li>
                <li>Third : {third}</li>
                <li>Fifth : {fifth}</li>
            </div>
        </div>
    );
}

function EvenPlayers([, second, , fourth, , sixth]) {
    return (
        <div>
            <h1>Even Players</h1>
            <div>
                <li>Second : {second}</li>
                <li>Fourth : {fourth}</li>
                <li>Sixth : {sixth}</li>
            </div>
        </div>
    );
}

function IndianPlayers({IndianPlayers}){
    return (
    <div>
      {IndianPlayers.map((player) => (
        <li>Mr. {player}</li>
      ))}
    </div>
  );
}
export { OddPlayers, EvenPlayers, IndianPlayers, IndianTeam, IndianPlayersMerged };