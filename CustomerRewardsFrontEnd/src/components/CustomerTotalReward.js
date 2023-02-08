import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Table, Spin } from 'antd';


const CustomerTotalReward = () => {
    const [apiResponse, setApiResponse] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchData = async () => {
            const api = await axios.get('http://localhost:8080/api/v1/customerRewards/Rewards');
            setApiResponse(api.data);
            setLoading(false);
        };
        fetchData();
    }, []);

    const columns = [
        {
            title: 'Name',
            dataIndex: 'name',
            key: 'name'
        },
        {
            title: 'Email',
            dataIndex: 'email',
            key: 'email'
        },
        {
            title: 'Total Reward Points',
            dataIndex: 'totalRewardPoints',
            key: 'totalRewardPoints'
        }
    ];

    return (
        <div>
            <Spin spinning={loading}>
                <Table dataSource={apiResponse} columns={columns} />
            </Spin>
        </div>
    );
};

export default CustomerTotalReward;