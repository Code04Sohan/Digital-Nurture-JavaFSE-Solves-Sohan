import logo from './logo.svg';
import './App.css';
import { CaldulateScore } from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CaldulateScore Name={"Sohan"} School={"PBBHS"} total={283} goal={3}/>
    </div>
  );
}

export default App;
