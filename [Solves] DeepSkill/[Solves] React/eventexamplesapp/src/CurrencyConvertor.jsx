import { useState } from 'react';

function CurrencyConvertor() {
    const [amount, setAmount] = useState("");
    const [currency, setCurrency] = useState("EURO");
    const [result, setResult] = useState(0);

    function handleSubmit(e) {
        e.preventDefault();
        const rate = 110.27;
        const inr = rate * amount;
        setResult(inr);
        alert(inr);
    }
    return (
        <div>
            <form onSubmit={handleSubmit}>
                <h1>Converter App!!!</h1>
                <label> Enter the Amount :
                    <input type="number" value={amount} onChange={(e) => setAmount(e.target.value)} />

                </label>
                <input type="submit" value="Convert" />
            </form>
            <h3>Converted Amount : {result}</h3>
        </div>

    );
}
export default CurrencyConvertor;