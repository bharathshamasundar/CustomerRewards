import './App.css';
import CustomerTotalReward from './components/CustomerTotalReward';
import Transactions from './components/Transactions';
import MonthlyRewards from './components/MonthlyRewards';
import { useState } from 'react';

function App() {
  const [selectedOption, setSelectedOption] = useState(null);

  const [value, setValue] = useState('');

  const handlePrompt = () => {
    const userValue = window.prompt('Enter a value:');
    setValue(userValue);
  }

  return (
    <div className="container">
      <p className="message">Customer Rewards Data Centre</p>
      <select className="dropdown-menu" onChange={(e) => setSelectedOption(e.target.value)}>
        <option value="">Select an option</option>
        <option value="CustomerTotalReward">Customer Total Rewards</option>
        <option value="Transactions">Transaction List</option>
        <option value="MonthlyCustomerReward">Monthly Customer Rewards</option>
      </select>

      {selectedOption === 'CustomerTotalReward' && <CustomerTotalReward />}
      {selectedOption === 'Transactions' && <Transactions />}
      {selectedOption === 'MonthlyCustomerReward' && (
        <div>
          <button onClick={handlePrompt}>Enter value</button>
          {value && <MonthlyRewards parameter={value} />}
        </div>
      )}
    </div>
  );
}

export default App;

