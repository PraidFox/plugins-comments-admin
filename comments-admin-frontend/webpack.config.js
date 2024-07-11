const path = require('path');
const webpack = require("webpack");

module.exports = {
    resolve: {
        extensions: ['.js', '.jsx', '.ts', '.tsx', '.json']
    },
    entry: './src/index.tsx',
    output: {
        path: path.join(__dirname, "./bundle"),
        filename: "main-view.js",
        library: 'CommentsAdmin',
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx|tsx|ts)$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader"
                }
            },
        ]
    },
    plugins: [
        new webpack.DefinePlugin({
            'process.env.REACT_APP_LOGIN': JSON.stringify(process.env.REACT_APP_LOGIN),
            'process.env.REACT_APP_PASSWORD': JSON.stringify(process.env.REACT_APP_PASSWORD),
            'process.env.REACT_APP_ISSUE_ID': JSON.stringify(process.env.REACT_APP_ISSUE_ID),
            'process.env.NODE_ENV': JSON.stringify(process.env.NODE_ENV),
        }),
    ],
};