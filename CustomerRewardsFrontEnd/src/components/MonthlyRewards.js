import React, { useState, useEffect } from 'react';
import { Table } from 'antd';



const columns = [
    {
        title: 'Name',
        dataIndex: 'name',
        key: 'name',
    },
    {
        title: 'Email',
        dataIndex: 'email',
        key: 'email',
    },
    {
        title: 'Rewards Map',
        dataIndex: 'rewardsMap',
        key: 'rewardsMap',
        render: (rewardsMap) => (
            <ul>
                {Object.entries(rewardsMap).map(([month, reward]) => (
                    <li key={month}>
                        {month}: {reward}
                    </li>
                ))}
            </ul>
        ),
    },
];




const MonthlyRewards = ({ parameter }) => {
    const [data, setData] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(`http://localhost:8080/api/v1/customerRewards/Rewards/${parameter}`);
            const json = await response.json();
            setData(json);
        };
        fetchData();
    }, [parameter]);

    return (
        <div>
            <Table columns={columns} dataSource={data} />
        </div>

    );
};

export default MonthlyRewards;