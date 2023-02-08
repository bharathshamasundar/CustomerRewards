import React, { useState, useEffect } from 'react';
import { Table } from 'antd';
import axios from 'axios';


const columns = [
    {
        title: 'Transaction ID',
        dataIndex: 'transactionId',
        key: 'transactionId',
    },
    {
        title: 'Customer Email',
        dataIndex: 'customerEmail',
        key: 'customerEmail',
    },
    {
        title: 'Customer Name',
        dataIndex: 'customerName',
        key: 'customerName',
    },
    {
        title: 'Total Purchase Amount(in $)',
        dataIndex: 'totalPurchaseAmount',
        key: 'totalPurchaseAmount',
    },
    {
        title: 'Purchase Date',
        dataIndex: 'purchaseDate',
        key: 'purchaseDate',
    },
];


const Transactions = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/customerRewards/Transactions')
            .then(res => setData(res.data))
            .catch(error => console.error(error));
    }, []);

    const rowClassName = (record, index) => {
        if (index % 2 === 0) {
            return 'ant-table-row-even';
        }
        return 'ant-table-row-odd';
    };

    return (
        <div>
            <Table
                columns={columns}
                dataSource={data}
                rowClassName={rowClassName}
                style={{ backgroundColor: 'white', marginTop: 16 }}
            />
        </div>

    );
};

export default Transactions;